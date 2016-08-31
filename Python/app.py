from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello_world():
    return 'Hello World!'

@app.route('/ujjwal/<name>')
def ujjwal(name):
    return 'Hello World! ' + name

if __name__ == '__main__':
    app.debug = True
    app.run()
