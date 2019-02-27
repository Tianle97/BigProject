from flask import Flask, url_for, render_template, request, json, jsonify, flash, redirect, session
import requests
import datetime
import time
import base64
import pprint


app = Flask(__name__)
app.secret_key = "123"

# drump to the default page(welcome page)
@app.route('/')
def welcome():
    return render_template("welcome.html")

@app.route('/index') 
def index():
   # return render_template("index.html")
    url = 'http://127.0.0.1:8080/index'
    r = requests.get(url)
    r_json = r.json()
    
    #data = r.read().decode("utf-8")
    pprint.pprint(type(r_json))
    print(type(r_json))
    print(type(r))
    print("aaa",type(r))


    return render_template('index.html')

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
    return r

@app.route('/login/<user>',methods=['POST'])
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
        return redirect("/onlineShopping?user=username")
        #return redirect("/onlineShopping?user=username")
    else:
        flash("username/password is wrong!")
    return render_template("index.html")

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


@app.route('/addProduct')
def addProduct_init():
    return render_template("addProduct.html")

def ServerAddProduct(name, price, t, ph):
    data = {'name': name, 'price': price,'type':t,'photo':ph}
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
    image_file = request.files['photo']
    # imgdata = base64.b64decode(image.split(",")[1])
    imgdata = str(base64.b64encode(image_file.read()))
    re = ServerAddProduct(name, price, t, imgdata)
    if not name:
        flash("please input name !")
        return render_template("addProduct.html")
    elif not price:
        flash("please input price !")
        return render_template("addProduct.html")
    elif not t:
        flash("please input type !")
        return render_template("addProduct.html")
    elif not image_file:
        flash("please input photo !")
        return render_template("addProduct.html")
    elif(re == 'seccess'):
        flash('add Products success!')
        return render_template("addProduct.html")


if __name__ == '__main__':
    app.debug = True
    app.run()
