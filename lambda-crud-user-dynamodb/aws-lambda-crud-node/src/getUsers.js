const AWS = require("aws-sdk");

const getUsers = async (event) => {
  // Generar un número aleatorio entre 1 y 5
  const randomNumber = Math.floor(Math.random() * 10) + 1;
  console.log(`Número aleatorio generado: ${randomNumber}`);

  // Lanzar una excepción si el número es 5
  if (randomNumber === 5) {
      throw new Error("Se ha producido un error aleatorio");
  }
  

  const dynamodb = new AWS.DynamoDB.DocumentClient();

  const result = await dynamodb.scan({ TableName: "usersTable" }).promise();

  const tasks = result.Items;

  return {
    status: 200,
    body: {
      tasks,
    },
  };
};

module.exports = {
    getUsers,
};