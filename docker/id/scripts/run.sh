echo "Starting ID Server..."
echo '$ID_HOME='$ID_HOME
echo '$ID_PORT='$ID_PORT
echo '$ID_JMX_PORT='$ID_JMX_PORT
echo '$ID_MANAGEMENT_PORT='$ID_JMX_PORT
echo '$POSTGRES_HOST='$POSTGRES_HOST
echo '$POSTGRES_PORT='$POSTGRES_PORT
echo '$POSTGRES_DB='$POSTGRES_DB
echo '$POSTGRES_USER='$POSTGRES_USER
echo '$POSTGRES_PASSWORD='$POSTGRES_PASSWORD
echo '$AUTH_HOST='$AUTH_HOST
echo '$AUTH_PORT='$AUTH_PORT
echo '$AUTH_ENDPOINT='$AUTH_ENDPOINT
echo '$AUTH_SERVER_CLIENTID='$AUTH_SERVER_CLIENTID
echo '$AUTH_SERVER_CLIENTSECRET='$AUTH_SERVER_CLIENTSECRET


$ID_HOME/bin/dcc-id-server start \
	wrapper.java.additional.2=-Dcom.sun.management.jmxremote.port=${ID_JMX_PORT} \
	wrapper.app.parameter.6=--server.port=${ID_PORT} \
	wrapper.app.parameter.7=--management.port=${ID_MANAGEMENT_PORT} \
	set.SPRING_DATASOURCE_URL="jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB}" \
	set.SPRING_DATASOURCE_USERNAME=$POSTGRES_USER \
	set.SPRING_DATASOURCE_PASSWORD=$POSTGRES_PASSWORD \
	set.AUTH_SERVER_URL="http://${AUTH_HOST}:${AUTH_PORT}/${AUTH_ENDPOINT}" \
	set.AUTH_SERVER_CLIENTID=$AUTH_SERVER_CLIENTID \
	set.AUTH_SERVER_CLIENTSECRET=$AUTH_SERVER_CLIENTSECRET
