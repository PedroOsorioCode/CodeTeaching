const { v4 } = require("uuid");
const AWS = require("aws-sdk");

const addUser = async (event) => {
  const dynamodb = new AWS.DynamoDB.DocumentClient();

  const { nombre, cedula } = JSON.parse(event.body);
  const createdAt = new Date();
  const id = v4();

  console.log("created id: ", id);

  const newUser = {
    id,
    nombre,
    cedula,
    createdAt,
    done: false,
  };

  await dynamodb
    .put({
      TableName: "usersTable",
      Item: newUser,
    })
    .promise();

  return {
    statusCode: 200,
    body: JSON.stringify(newUser),
  };
};

module.exports = {
    addUser,
};