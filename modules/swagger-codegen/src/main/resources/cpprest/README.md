# Swagger Code Generator for Microsoft Casablanca/cpprest project
This is still work in progress (not yet complete) and will get updated regularly.

## Overview
This generator creates a prooxy between cpprest and your code. You will get a set of classes to use that encapsulates all parsing and http handling.

Check out Microsoft Casablanca/cpprest project at [CodePlex](https://casablanca.codeplex.com/) or [GitHub](https://github.com/Microsoft/cpprestsdk)

## Sample code
This is all you need to be able to do a REST call using result from this generator.

```
swagger::cpprest::user::HttpManager httpManager;
std::weak_ptr<swagger::cpprest::request::user::CreateCreateUserRequest> request = httpManager.createCreateUserRequest();
std::shared_ptr<swagger::cpprest::model::User> user(new swagger::cpprest::model::User);
// Fill data in user object...
user->setId(1001);
...
request.lock()->post(user, [](unsigned short statusCode, const swagger::cpprest::model::ModelObject& obj) {
	// You get here when the call has finished. Check for success/failure
});

```

# Documentation

## Class HttpManager
With this class you create all request types. You will get back a weak_ptr to the request.
The HttpManager will take care of destructions of all outstanding requests when itself is deleted.
TODO: Add more text

## Classes related to requests
These classes relates to the operations in your API definition file.
TODO: Add more text

## Classes related to definitions
These classes relates to the definitions in your API definion file.
TODO: Add more text

# Features left to be implemented
- Add default values in models
- Adhere to definition property format
- Add 'add...' method for adding an item in a list/map.
- Add validation of required vars in a model
- Lots more...
