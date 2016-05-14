// Extensions.swift
//
// Generated by swagger-codegen
// https://github.com/swagger-api/swagger-codegen
//

import Alamofire
import PromiseKit

extension Bool: JSONEncodable {
    func encodeToJSON() -> AnyObject { return self }
}

extension Float: JSONEncodable {
    func encodeToJSON() -> AnyObject { return self }
}

extension Int: JSONEncodable {
    func encodeToJSON() -> AnyObject { return self }
}

extension Int32: JSONEncodable {
    func encodeToJSON() -> AnyObject { return NSNumber(int: self) }
}

extension Int64: JSONEncodable {
    func encodeToJSON() -> AnyObject { return NSNumber(longLong: self) }
}

extension Double: JSONEncodable {
    func encodeToJSON() -> AnyObject { return self }
}

extension String: JSONEncodable {
    func encodeToJSON() -> AnyObject { return self }
}

private func encodeIfPossible<T>(object: T) -> AnyObject {
    if object is JSONEncodable {
        return (object as! JSONEncodable).encodeToJSON()
    } else {
        return object as! AnyObject
    }
}

extension Array: JSONEncodable {
    func encodeToJSON() -> AnyObject {
        return self.map(encodeIfPossible)
    }
}

extension Dictionary: JSONEncodable {
    func encodeToJSON() -> AnyObject {
        var dictionary = [NSObject:AnyObject]()
        for (key, value) in self {
            dictionary[key as! NSObject] = encodeIfPossible(value)
        }
        return dictionary
    }
}


private let dateFormatter: NSDateFormatter = {
    let dateFormatter = NSDateFormatter()
    dateFormatter.dateFormat = "yyyy-MM-dd"
    return dateFormatter
}()

extension NSDate: JSONEncodable {
    func encodeToJSON() -> AnyObject {
        return dateFormatter.stringFromDate(self)
    }
}

extension RequestBuilder {
    public func execute() -> Promise<Response<T>>  {
        let deferred = Promise<Response<T>>.pendingPromise()
        self.execute { (response: Response<T>?, error: ErrorType?) in
            if let response = response {
                deferred.fulfill(response)
            } else {
                deferred.reject(error!)
            }
        }
        return deferred.promise
    }
}
