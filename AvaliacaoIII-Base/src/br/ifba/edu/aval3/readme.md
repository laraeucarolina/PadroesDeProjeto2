# Padrões de Projeto

## Questão I - State
- **Padrão**: State
- **Justificativa**: a classe `BoletimProva` muda de comportamento conforme a fase da prova. O padrão State organiza essas mudanças em objetos separados, facilitando extensão e manutenção.
- **Papéis**:
  - `BoletimProva` - Contexto
  - `FaseProva` - Estado
  - `PreProvaState`, `MomentoLargadaState`, `PistaState`, `PosProvaState` - Implementações de estado

## Questão II - Chain of Responsibility
- **Padrão**: Chain of Responsibility
- **Justificativa**: a apuração da prova envolve várias regras encadeadas que podem variar conforme a configuração. Com o padrão Chain of Responsibility é possível adicionar ou remover regras sem alterar as existentes.
- **Papéis**:
  - `Apurador` - Configura e inicia a cadeia
  - `RegraApuracao` - Handler abstrato
  - `RegraTempoBase`, `RegraTempoMaximo`, `RegraOrdemPrismas`, `RegraTodosPrismasRegistrados`, `RegraPenalizarAtraso` - Handlers concretos
