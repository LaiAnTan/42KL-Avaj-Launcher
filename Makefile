SRC_PATH = ./src

all: re

compile:
	@echo "Compiling..."

	find $(SRC_PATH) -name "*.java" > sources.txt
	javac @sources.txt -d .
	rm sources.txt

run:
	java Main

clean:
	rm *.class

re: compile run