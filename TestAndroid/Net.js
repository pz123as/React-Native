'user strict';

import {
  NativeModules
} from 'react-native';

var RCTNet = NativeModules.Net;

var Net = {
  getResult: function(url: string, callback: Function):void{
    RCTNet.getResult(url, callback);
  }
};

module.exports = Net;
