# OAuth + OIDC

Este proyecto muestra cómo implementar autenticación y autorización en un backend desarrollado con Quarkus utilizando OAuth 2.0 y OpenID Connect (OIDC), integrando un proveedor de identidad externo.

## 📦 ¿Qué incluye este proyecto?

- Autenticación con OAuth 2.0 (Authorization Code Flow)
- Integración con proveedor OIDC (ej: Google, Auth0, etc.)
- Validación de tokens JWT
- Ejemplo de endpoints protegidos
- Configuración lista para entorno local

## 🔄 Flujo de autenticación

1. El usuario intenta acceder a un recurso protegido.
2. Es redirigido al proveedor de identidad (OIDC).
3. El usuario se autentica.
4. El proveedor devuelve un authorization code.
5. El backend intercambia el code por un access token.
6. Se validan los claims del token.
7. Se permite el acceso al recurso protegido.

## 🔄 Flujo OAuth + OIDC

El siguiente diagrama muestra el flujo completo de autenticación utilizando Authorization Code Flow con OpenID Connect, incluyendo renovación silenciosa de sesión.

## Requisitos
- Java 21 
- mvn gestor de paquetes instalado
- Docker si quisieras crear una imagen y correr la app en un contenedor.
- Acceso a consola cloud para configurar el Cliente OAuth.

## Forma de uso

1. Instalar las dependencias de mvn ejecutar en la raiz del proyecto el siguiente comando

    ```shell script
    ./mvnw clean install
    ```

2. En la consola del proveedor cloud que utilices ingresar a la parte de Clientes de OAuth y dar de alta un nuevo cliente.
- Agregar un nombre de referencia para el cliente.
- Seleccionar web-app en el tipo de aplicacion.
- Ingresar los origenes de JavaScript autorizados en caso de que tu aplicacion tenga un frontend.
- Ingresar las URIs de redireccionamiento autorizadas, para este ejemplo en un entorno local: `http://localhost:8081/`,
`http://localhost:8081/dashboard/admin/`, `http://localhost:8081/tokens/`
- Crear el cliente OAuth copiar los valores de Client ID y Secret para darlos de alta en variables de entorno.
- Opcional: Podes descargar el JSON que te da con los datos de tu cliente de OAuth.

3. Configurar los valores correspondientes en el archivo .properties, referentes a los siguientes parametros:
    ```shell script
    quarkus.oidc.provider=${NAME_PROVIDER}
    quarkus.oidc.client-id=${CLIENT_ID}
    quarkus.oidc.credentials.secret=${SECRET}
    ```

    > [!CAUTION]
    >
    > No subir los valores harcodeados a repositorios ni publicos ni privados, dar de alta estos parametros en variables de entorno para pruebas locales, y en ambientes productivos utilizar algun gestor de credenciales valido.


4. Ejecutar la aplicacion de forma local, en un entorno de desarrollo con el siguiente comando:

    ```shell script
    ./mvnw quarkus:dev
    ```

## Documentacion oficial de apoyo

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- OpenID Connect ([guide](https://quarkus.io/guides/security-openid-connect)): Verify Bearer access tokens and authenticate users with Authorization Code Flow

## 👤 Autor

Codea Seguro - [@codeaseguro](https://github.com/codeaseguro)


