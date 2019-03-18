from flask import Flask, url_for, render_template, request, json, jsonify, flash, redirect, session
import requests
import datetime
import time
import base64

app = Flask(__name__)
app.secret_key = "123"

# drump to the default page(welcome page)
@app.route('/')
def welcome():
    return render_template("welcome.html")

@app.route('/index') 
def index():
    Parsed_json = getProducts()
    print(Parsed_json[0]['name'])
    return render_template('index.html', products = Parsed_json,)

def getProducts():
    url = 'http://127.0.0.1:8080/show'
    r = requests.get(url)
    return json.loads(r.text)

@app.route('/login')
def login():
    return render_template("login.html")

def ServerLogin(user,psd):
    params = {
        'username': user,
        'password': psd
    }
    url = 'http://127.0.0.1:8080/login'
    r = requests.get(url, params).text
    print("222",r)
    return r

@app.route('/login',methods=['POST'])
def login_get():
    global user
    form = request.form
    username = form.get('username')
    password = form.get('password')
    re = ServerLogin(username,password)
    if not username:
        flash("please input username !")
    elif not password:
        flash("please input password !")
    elif(re == 'successful'):
        user = username
        return redirect("logined")
    else:
        flash("username/password is wrong!")
    return render_template("login.html")

@app.route('/logined')
def longined():
    global user
    Parsed_json = getProducts()
    return render_template("logined.html",username=user,items = Parsed_json)

@app.route('/register')
def register_init():
    return render_template("register.html")

def ServerRegister(user,psd,add,ph,bal):
    data = {'username': user, 'password': psd,'address':add,'phone':ph,'balance':bal}
    url = 'http://127.0.0.1:8080/register'
    r = requests.post(url, json = data)
    Parsed_json = json.loads(r.text)
    return Parsed_json['msg']


@app.route('/user', methods=['POST'])
def register():
    form = request.form
    username = form.get('username')
    password = form.get('password')
    address = form.get('address')
    phone = form.get('phone')
    balance = form.get('balance')
    re = ServerRegister(username, password,address,phone,balance)
    if not username:
        flash("please input username !")
        return render_template("register.html")
    elif not password:
        flash("please input password !")
        return render_template("register.html")
    elif(re == 'duplicate_user'):
        flash('ERROR: user exist!')
        return render_template("register.html")
    elif(re == 'registered'):
        flash('register success!')
        return render_template("login.html")

# For user add product to the index page
@app.route('/addProduct')
def addProduct_init():
    return render_template("addProduct.html")

# 
def ServerAddProduct(name, price, t, ph, st):
    data = {'name': name, 'price': price,'type':t,'photo':ph, 'stocks':st}
    url = 'http://127.0.0.1:8080/addProduct'
    r = requests.post(url, json = data)
    Parsed_json = json.loads(r.text)
    return Parsed_json['msg']

@app.route('/add', methods=['POST'])
def addProduct():
    form = request.form
    name = form.get('name')
    price = form.get('price')
    t = form.get('type')
    st = form.get('stocks')
    image_file = request.files['photo']
    # imgdata = base64.b64decode(image.split(",")[1])
    imgdata_b = str(base64.b64encode(image_file.read()))
    imgdata = 'data:image/png;base64,'+imgdata_b[2:-1]
    re = ServerAddProduct(name, price, t,imgdata,st)
    if not name:
        flash("please input name !")
        return render_template("addProduct.html")
    elif not price:
        flash("please input price !")
        return render_template("addProduct.html")
    elif not t:
        flash("please input type !")
        return render_template("addProduct.html")
    elif not st:
        flash("please input stocks !")
        return render_template("addProduct.html")
    elif not image_file:
        flash("please input photo !")
        return render_template("addProduct.html")
    elif(re == 'seccess'):
        return redirect('index')

# this route for user buy products 
# use global value for easy get id in this function
@app.route('/buyProduct',methods = ['POST']) 
def buyProduct():
    global id
    id = request.args.get('id')
    print(id)
    Parsed_json = buy(id)
    print('----->',Parsed_json['name'])
    return id
    #return render_template('buy.html', items = Parsed_json)

# A function send url to back-end for get product information from Mongodb
def buy(id):
    url = 'http://127.0.0.1:8080/buy?id='+id
    r = requests.get(url)
    return json.loads(r.text)

@app.route('/buy') 
def getProduct():
    global id
    Parsed_json = buy(id)
    print("buy",id)
    #print(Parsed_json)
    return render_template("buy.html",item = Parsed_json)

if __name__ == '__main__':
    app.debug = True
    app.run()
