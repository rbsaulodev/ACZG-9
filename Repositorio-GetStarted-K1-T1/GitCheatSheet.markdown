### 1. Essencial e Atalhos

* `git init`: Inicia o repositório.
* `git add .`: Prepara as mudanças.
* `git commit -m "msg"`: Salva as alterações.
* `git commit -a -m "msg"`: Adiciona (arquivos editados) e commita em um único passo.
* `git status`: Resumo do estado atual.
* `git log --oneline`: Histórico curto.

### 2. Fetch e Sincronização

* `git fetch`: Baixa as novidades do servidor sem alterar seu código.
* `git fetch --prune`: Limpa referências de branches deletadas no remoto.
* `git pull`: Baixa e aplica as mudanças (fetch + merge).
* `git push`: Envia suas mudanças.

### 3. Busca e Configuração (Grep & Alias)

* `git grep "termo"`: Busca por palavras dentro dos arquivos do repositório.
* `git config --global alias.<atalho> <comando>`: Cria um apelido para um comando.
* *Ex: `git config --global alias.st status` (agora `git st` funciona).*



### 4. Branches e Stash

* `git checkout -b <nome>`: Cria e entra na branch.
* `git switch <nome>`: Troca de branch.
* `git stash`: Esconde mudanças temporárias.
* `git stash pop`: Recupera o que foi escondido.

### 5. Rebase (Histórico Limpo)

* `git rebase <branch>`: Move seus commits para o topo da branch alvo.
* `git rebase -i HEAD~n`: Interativo: `pick` (manter), `reword` (msg), `squash` (juntar).
* `git rebase --continue`: Segue após resolver conflitos.

### 6. Avançado e Depuração

* `git cherry-pick <hash>`: Copia um commit específico.
* `git reset --hard <hash>`: Volta no tempo apagando tudo depois.
* **Git Bisect (Caça-Bug):**
1. `git bisect start` -> `git bisect bad` (ruim) -> `git bisect good <hash>` (bom).
2. Teste e responda: `git bisect good` ou `bad`.
3. `git bisect reset` (finaliza).

