const AWS = require("aws-sdk");
AWS.config.update({ region: 'us-east-1' });

function snsRequest(mensaje) {
    var params = {
        Message: mensaje,
        TopicArn: 'arn:aws:sns:us-east-1:284244831666:snsPedido'
    };
    
    return new AWS.SNS({ apiVersion: '2010-03-31' }).publish(params).promise();
}

exports.handler = async (event, context) => {
    try {
        await snsRequest("Se ha solicitado un pedido de tu producto");
        console.log("Mensaje enviado correctamente");
    } catch (error) {
        console.error("Error al enviar el mensaje: ", error);
    }
};
