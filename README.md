# ATYA Init Script Runner

[![official JetBrains project](https://jb.gg/badges/official.svg)][jb:github]
[![Twitter Follow](https://img.shields.io/badge/follow-%40JBPlatform-1DA1F2?logo=twitter)](https://twitter.com/JBPlatform)

![Atya Logo]![Atya_logo](https://github.com/bharatnpti/dddd/assets/35888424/8441a80a-de01-4131-ba40-e0a8a72c7e11)

<!-- Plugin description -->
This is an IntelliJ plugin that enhances the project opening experience by executing Bash scripts located in the .scripts folder of the project. This plugin enables developers to automate various tasks and customize the project environment upon project open.

Key Features:

Script Execution: Upon opening a project in IntelliJ, the plugin automatically scans the project's .scripts folder and executes any Bash scripts found within it. This allows to define custom actions, configurations, or setups that need to be performed every time the project is opened.

Project-Specific Scripts: The plugin focuses on project-specific scripts, providing a convenient way to encapsulate project-specific logic or configurations. By organizing Bash scripts within the .scripts folder, it can be ensured that project-specific tasks are executed consistently across the team.

Automation and Customization: It enables teams/developers to automate routine tasks, set up local environment configurations, or perform custom actions specific to the project. It offers flexibility and extensibility to tailor the project setup according to needs.

Git Hooks Integration: One valuable use case of this plugin is the ability to set up Git hooks on the local machines of all developers in a team. By placing the scripts to setup git hooks in the .scripts folder, the plugin can automatically execute them upon project open, ensuring consistent Git hook configurations across the team.

With this plugin, teams can streamline project setup, automate repetitive tasks, and ensure consistent project environments. It empowers teams to enforce standards, improve productivity, and maintain a cohesive development experience across projects.
<!-- Plugin description end -->