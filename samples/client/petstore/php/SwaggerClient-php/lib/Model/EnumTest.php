<?php
/**
 * EnumTest
 *
 * PHP version 5
 *
 * @category Class
 * @package  Swagger\Client
 * @author   http://github.com/swagger-api/swagger-codegen
 * @license  http://www.apache.org/licenses/LICENSE-2.0 Apache Licene v2
 * @link     https://github.com/swagger-api/swagger-codegen
 */
/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

namespace Swagger\Client\Model;

use \ArrayAccess;

/**
 * EnumTest Class Doc Comment
 *
 * @category    Class
 * @description 
 * @package     Swagger\Client
 * @author      http://github.com/swagger-api/swagger-codegen
 * @license     http://www.apache.org/licenses/LICENSE-2.0 Apache Licene v2
 * @link        https://github.com/swagger-api/swagger-codegen
 */
class EnumTest implements ArrayAccess
{
    /**
      * The original name of the model.
      * @var string
      */
    static $swaggerModelName = 'Enum_Test';

    /**
      * Array of property to type mappings. Used for (de)serialization
      * @var string[]
      */
    static $swaggerTypes = array(
        'enum_string' => 'string',
        'enum_integer' => 'int',
        'enum_number' => 'double'
    );

    static function swaggerTypes() {
        return self::$swaggerTypes;
    }

    /**
     * Array of attributes where the key is the local name, and the value is the original name
     * @var string[]
     */
    static $attributeMap = array(
        'enum_string' => 'enum_string',
        'enum_integer' => 'enum_integer',
        'enum_number' => 'enum_number'
    );

    static function attributeMap() {
        return self::$attributeMap;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses)
     * @var string[]
     */
    static $setters = array(
        'enum_string' => 'setEnumString',
        'enum_integer' => 'setEnumInteger',
        'enum_number' => 'setEnumNumber'
    );

    static function setters() {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests)
     * @var string[]
     */
    static $getters = array(
        'enum_string' => 'getEnumString',
        'enum_integer' => 'getEnumInteger',
        'enum_number' => 'getEnumNumber'
    );

    static function getters()
    {
        return self::$getters;
    }

    

    
    /**
     * Gets allowable values of the enum
     * @return string[]
     */
    public function getEnumStringAllowableValues()
    {
        return [
            
        ];
    }
    
    /**
     * Gets allowable values of the enum
     * @return string[]
     */
    public function getEnumIntegerAllowableValues()
    {
        return [
            
        ];
    }
    
    /**
     * Gets allowable values of the enum
     * @return string[]
     */
    public function getEnumNumberAllowableValues()
    {
        return [
            
        ];
    }
    

    /**
     * Associative array for storing property values
     * @var mixed[]
     */
    protected $container = array();

    /**
     * Constructor
     * @param mixed[] $data Associated array of property value initalizing the model
     */
    public function __construct(array $data = null)
    {
        $this->container['enum_string'] = isset($data['enum_string']) ? $data['enum_string'] : null;
        $this->container['enum_integer'] = isset($data['enum_integer']) ? $data['enum_integer'] : null;
        $this->container['enum_number'] = isset($data['enum_number']) ? $data['enum_number'] : null;
    }

    /**
     * show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function list_invalid_properties()
    {
        $invalid_properties = array();
        $allowed_values = array("UPPER", "lower");
        if (!in_array($this->container['enum_string'], $allowed_values)) {
            $invalid_properties[] = "invalid value for 'enum_string', must be one of #{allowed_values}.";
        }
        $allowed_values = array("1", "-1");
        if (!in_array($this->container['enum_integer'], $allowed_values)) {
            $invalid_properties[] = "invalid value for 'enum_integer', must be one of #{allowed_values}.";
        }
        $allowed_values = array("1.1", "-1.2");
        if (!in_array($this->container['enum_number'], $allowed_values)) {
            $invalid_properties[] = "invalid value for 'enum_number', must be one of #{allowed_values}.";
        }
        return $invalid_properties;
    }

    /**
     * validate all the properties in the model
     * return true if all passed
     *
     * @return bool True if all properteis are valid
     */
    public function valid()
    {
        $allowed_values = array("UPPER", "lower");
        if (!in_array($this->container['enum_string'], $allowed_values)) {
            return false;
        }
        $allowed_values = array("1", "-1");
        if (!in_array($this->container['enum_integer'], $allowed_values)) {
            return false;
        }
        $allowed_values = array("1.1", "-1.2");
        if (!in_array($this->container['enum_number'], $allowed_values)) {
            return false;
        }
        return true;
    }


    /**
     * Gets enum_string
     * @return string
     */
    public function getEnumString()
    {
        return $this->container['enum_string'];
    }

    /**
     * Sets enum_string
     * @param string $enum_string 
     * @return $this
     */
    public function setEnumString($enum_string)
    {
        $allowed_values = array('UPPER', 'lower');
        if (!in_array($enum_string, $allowed_values)) {
            throw new \InvalidArgumentException("Invalid value for 'enum_string', must be one of 'UPPER', 'lower'");
        }
        $this->container['enum_string'] = $enum_string;

        return $this;
    }

    /**
     * Gets enum_integer
     * @return int
     */
    public function getEnumInteger()
    {
        return $this->container['enum_integer'];
    }

    /**
     * Sets enum_integer
     * @param int $enum_integer 
     * @return $this
     */
    public function setEnumInteger($enum_integer)
    {
        $allowed_values = array('1', '-1');
        if (!in_array($enum_integer, $allowed_values)) {
            throw new \InvalidArgumentException("Invalid value for 'enum_integer', must be one of '1', '-1'");
        }
        $this->container['enum_integer'] = $enum_integer;

        return $this;
    }

    /**
     * Gets enum_number
     * @return double
     */
    public function getEnumNumber()
    {
        return $this->container['enum_number'];
    }

    /**
     * Sets enum_number
     * @param double $enum_number 
     * @return $this
     */
    public function setEnumNumber($enum_number)
    {
        $allowed_values = array('1.1', '-1.2');
        if (!in_array($enum_number, $allowed_values)) {
            throw new \InvalidArgumentException("Invalid value for 'enum_number', must be one of '1.1', '-1.2'");
        }
        $this->container['enum_number'] = $enum_number;

        return $this;
    }
    /**
     * Returns true if offset exists. False otherwise.
     * @param  integer $offset Offset
     * @return boolean
     */
    public function offsetExists($offset)
    {
        return isset($this->container[$offset]);
    }

    /**
     * Gets offset.
     * @param  integer $offset Offset
     * @return mixed
     */
    public function offsetGet($offset)
    {
        return isset($this->container[$offset]) ? $this->container[$offset] : null;
    }

    /**
     * Sets value based on offset.
     * @param  integer $offset Offset
     * @param  mixed   $value  Value to be set
     * @return void
     */
    public function offsetSet($offset, $value)
    {
        if (is_null($offset)) {
            $this->container[] = $value;
        } else {
            $this->container[$offset] = $value;
        }
    }

    /**
     * Unsets offset.
     * @param  integer $offset Offset
     * @return void
     */
    public function offsetUnset($offset)
    {
        unset($this->container[$offset]);
    }

    /**
     * Gets the string presentation of the object
     * @return string
     */
    public function __toString()
    {
        if (defined('JSON_PRETTY_PRINT')) { // use JSON pretty print
            return json_encode(\Swagger\Client\ObjectSerializer::sanitizeForSerialization($this), JSON_PRETTY_PRINT);
        }

        return json_encode(\Swagger\Client\ObjectSerializer::sanitizeForSerialization($this));
    }
}
