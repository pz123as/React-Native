/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  DeviceEventEmitter
} from 'react-native';

var Log = require('./Log');
var Net = require('./Net');

class TestAndroid extends Component {
  constructor(props){
    super(props);
    Net.getResult("http://www.baidu.com", (code,result)=>{
      console.log("callback", code, result);
    });
  }
  componentDidMount(){
    Log.d(Log.TAG, "12345!");
    DeviceEventEmitter.addListener('logInConsole', this.logInConsole.bind(this));
  }
  logInConsole(event){
    console.log(event);
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('TestAndroid', () => TestAndroid);
