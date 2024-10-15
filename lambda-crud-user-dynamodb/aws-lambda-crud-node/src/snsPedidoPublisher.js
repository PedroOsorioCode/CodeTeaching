const AWS = require("aws-sdk");
AWS.config.update({region: 'us-east-1'});

function snsRequest(mensaje){
    var params = {
        Message: mensaje,
        TopicArn: 'arn:aws:sns:us-east-1:284244831666:snsPedido'
    };
    var publishTextPromise = new AWS.SNS({apiVersion: '2024-10-14'}).publish(params).promise();
}

exports.handler.snsRequest = (event, context, handler) => {
    snsRequest("Se ha solicitado un pedido de tu producto");
}