# Set-up

Required:
- Java 21+
- Maven
- Docker or some other container manager

## DevContainer
TODO?

# Running the project

First of, decide if you want to use OpenAI or Ollama. Other options are ofcourse available but this project comes with these two options pre-configured.

Ollama will run a LLM locally, so it's free and private, but requires more resources (GPU/CPU) and will be slower in responsiveness than OpenAI.

OpenAI will use the OpenAI API, you will have to pay for API usage, but it won't requires local resources (CPU/GPU) and will be faster than running a LLM locally.

1. If you are going to use OpenAI, disable Ollama in the `compose.yaml` file.
1. Run `docker-compose up` from root directory (or alternative equivalent).
2. In `pom.xml`, use either the OpenAI or Ollama dependency.
3. Set-up LLM for first time running:
   1. **OpenAI**: in application.properties, place your OpenAI API key
   2. **Ollama**: after the Ollama container is running, it still needs to initialize a model, execute the following: `docker exec -it ollama ollama run mistral`. This will start the Mistral model in your Ollama container. See https://hub.docker.com/r/ollama/ollama for instructions or https://ollama.com/ to pick a different model. 
3. Run the project, either via IntelliJ or `./mvnw spring-boot:run` from command-line

The default database schema and data originate from the `schema.sql` and `import.sql` files.