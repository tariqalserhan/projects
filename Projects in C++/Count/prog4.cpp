#include "Count.h"
#include "prog4_funcs.h"

int main(int argc, char *argv[]) {
  parseArgs(argc, argv);

  Count count;

  parseFile(&count);

  return 0;
}