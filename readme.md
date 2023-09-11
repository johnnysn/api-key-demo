
# API Key Authorization Demo

This is a simple demo application built with Spring Boot 3.1 to demonstrate how to configure Spring Security 6
for API key authorization. 
It has two endpoints: `/public/greetings` and `/protected/greetings`. 
All endpoints with the pattern `/public/**` are not protected, 
while others require API key authorization using an HTTP header with an `ApiKey` entry. 
The API key is configured through the environment variable `API_KEY`.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher installed on your system.
- Gradle installed to build and package the application.

## Getting Started

1. Clone this repository to your local machine:

   ```shell
   git clone https://github.com/johnnysn/api-key-demo.git
   ```

2. Navigate to the project directory:

   ```shell
   cd api-key-demo
   ```

3. Configure the application:

    To configure API key authorization, you need to set the `API_KEY` environment variable. The application reads this variable and uses its value to validate API key headers for protected endpoints.
    
    ```shell
    export API_KEY=your_api_key_here
    ```

    Make sure to replace `your_api_key_here` with your actual API key.

4. Build and run the application:

   ```shell
   gradle bootRun
   ```

5. The application will start, and you can access it at `http://localhost:8080`.

## Endpoints

1. **Public Greetings** (Unprotected):
    - Endpoint: GET `/public/greetings`
    - Description: This endpoint is not protected and can be accessed without an API key.
    - Output: A greetings string

2. **Protected Greetings** (Requires API Key):
    - Endpoint: GET `/protected/greetings`
    - Description: This endpoint requires API key authorization. Include an HTTP header with the key `ApiKey` and the value of your API key to access it.
    - Output: Another greetings string

## License

This project is licensed under the [MIT License](LICENSE).