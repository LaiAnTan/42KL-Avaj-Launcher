SRC_PATH = src

CLASSFILE_PATH = build

SCENARIO_FILE = assets/scenario2.txt

MAIN = Main

all: re

compile:
	@echo "Compiling..."

	find $(SRC_PATH) -name "*.java" > sources.txt
	javac @sources.txt -d $(CLASSFILE_PATH)

run:
	java -cp $(CLASSFILE_PATH) $(MAIN) $(SCENARIO_FILE)

clean:
	rm -rf $(CLASSFILE_PATH)

re: compile run