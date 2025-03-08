#!/bin/bash


PROJECT_DIR="$HOME/Desktop/TP QA3/classique"


if [ -d "$PROJECT_DIR" ]; then
  echo "Accès au projet valide, exécution des tests..."
  cd "$PROJECT_DIR"  
  mvn clean test     
  echo "Tests terminés!"
else
  echo "Le chemin du projet est invalide. Vérifiez que le répertoire existe."
fi
