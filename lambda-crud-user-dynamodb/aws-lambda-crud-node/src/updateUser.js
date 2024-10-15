const uuid = require("uuid");
const AWS = require("aws-sdk");

const updateUser = async (event) => {
  const dynamodb = new AWS.DynamoDB.DocumentClient();
  const { id } = event.pathParameters;

  const { nombre, cedula } = JSON.parse(event.body);

  await dynamodb
    .update({
      TableName: "usersTable",
      Key: { id },
      UpdateExpression: "set nombre = :nombre, cedula = :cedula",
      ExpressionAttributeValues: {
        ":nombre": nombre, ":cedula": cedula
      },
      ReturnValues: "ALL_NEW",
    })
    .promise();

  return {
    status: 200,
    body: JSON.stringify({
      message: "user updated",
    }),
  };
};

module.exports = {
    updateUser,
};