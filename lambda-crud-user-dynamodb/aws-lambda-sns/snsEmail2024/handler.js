const AWS = require("aws-sdk");
AWS.config.update({ region: 'us-east-1' });
const { metricScope } = require("aws-embedded-metrics");

function snsRequest(mensaje) {
    var params = {
        Message: mensaje,
        TopicArn: 'arn:aws:sns:us-east-1:284244831666:snsPedido'
    };
    
    return new AWS.SNS({ apiVersion: '2010-03-31' }).publish(params).promise();
}

exports.snsEmail = metricScope(metrics => async (event, context) => {
    const startTime = new Date().toISOString();

    try {
        
        // Agregando información inicial a las métricas
        metrics.setNamespace("SNSPedidoApp");
        metrics.putDimensions({ Function: "snsRequest" });
        metrics.putMetric("Invocations", 1, "Count");
        metrics.putMetric("MemoryUsageStart", process.memoryUsage().heapUsed, "Bytes");

        await snsRequest("Se ha solicitado un pedido de tu producto");

        // Calculando duración y uso de memoria
        const duration = new Date() - new Date(startTime);
        metrics.putMetric("Duration", duration, "Milliseconds");
        metrics.putMetric("MemoryUsageEnd", process.memoryUsage().heapUsed, "Bytes");

        // Métrica para éxito
        metrics.putMetric("Success", 1, "Count");

        // Retornando el mensaje de éxito
        return {
            statusCode: 200,
            body: JSON.stringify({
                message: "Se ha enviado el correo correctamente"
            })
        };

    } catch (error) {
        // Métrica para error
        metrics.putMetric("Error", 1, "Count");

        console.error("Error al enviar el mensaje:", error);

        // Retorna un mensaje de error
        return {
            statusCode: 500,
            body: JSON.stringify({
                message: "Error al enviar el correo"
            })
        };
    }
});