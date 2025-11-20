# PEARS 🍐🍐

Pears is a web application built with Spring Boot and React that helps developers pair up for collaboration. 
Users can create custom pairings or generate random pairs to streamline teamwork and improve productivity.


### Requirements
- Java JDK 21
- IntelliJ community edition is good or VsCode
- SSH

### How to start locally (IntelliJ IDEA)
1. Check Java 21 is installed `java --version`.
   - If not installed you cn install from [Oracle using the x64 Installer](https://www.oracle.com/java/technologies/downloads/#jdk25-windows).
2. Clone the [Pears Repository](https://github.com/AnnaGarcia1207/pears).
    ```bash
   git clone git@github.com:AnnaGarcia1207/pears.git
   ```
3. Start the program locally:
    ```bash
   ./mvnw spring-boot:run
    ```
   


### Set up SSH with GitHub
1. Check if you already have SSH keys. Look for `id_ed25519` and `id_ed25519.pub`
    ```bash
    ls -a ~/.ssh
   ```
   1. If exists, move on to step 4
2. Generate new SSH keys `ssh-keygen -t ed25519 -C "your_email@example.com"`
    ```bash
    ~/.ssh/id_ed25519
    ~/.ssh/id_ed25519.pub
   ```
3. Start the SSH agent and add your key - This is to start SSH agent in the background.
    ```bash
   eval $(ssh-agent -s)
   ssh-add ~/.ssh/id_ed25519
   ```
4. Add your SSH key to GitHub.
   1. From your terminal copy the public key: `cat ~/.ssh/id_ed25519.pub`
   2. Go to https://github.com/settings/keys then New SSH key.
   3. Title : `(However you want)` | Key Type: `Authentication Key` | Key: `(paste the copied key)`
5. Test your SSH connection to GitHub 
    ```bash
   ssh -T git@github.com
   ```
