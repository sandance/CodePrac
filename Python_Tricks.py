

def apply_discount(product, discount):
    price = int(product['price'] * ( 1.0 - discount))
    assert 0 <= price <= product['price']
    return price

shoes = { 'name' : 'Fancy Shoes', 'price' : 14900}
print (apply_discount(shoes, 0.25))


names = ['Alice', 'Bob', 'Dilbert']

name = [
    'Alice',
    'Bob',
    'Dilbert'
]

with open('hello.txt', 'w') as f:
    f.write("Hello World")

sock_lock = threading.Lock()

with some_lock:
    #Do something

