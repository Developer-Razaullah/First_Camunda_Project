print('This Message Invoke from Department Task');
print("Previous Object1 Values:"+JSON.stringify(userObj));
print("Previous Object2 Values:"+JSON.stringify(userObj1));
print("Previous Object3 Values:"+JSON.stringify(userObj2));

print("Previous Object4 Values:"+JSON.stringify(userObj4));


print("Previous Object4 Values:"+JSON.stringify(execution.getVariable('userObj4')));

var obj = {
id : 1,
name: 'IT'
}

print("Department Object:"+JSON.stringify(obj));