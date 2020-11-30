package graphic;

 public enum LanguagePattern {
    ENGLISH("File", "Disclaimer", "Exit", "Help", "About", "Convert From", "To"),
    PORTUGUESE("Início", "Avisos Legais", "Sair", "Ajuda", "Sobre", "Converter de", "Para");

    private String file;
    private String disclaimer;
    private String exit;
    private String help;
    private String about;
    private String convertFrom;
    private String convertTo;

    private LanguagePattern(String file, String disclaimer, String exit, String help,
			String about, String convertFrom, String convertTo) {
		this.file = file;
		this.disclaimer = disclaimer;
		this.exit = exit;
		this.help = help;
		this.about = about;
		this.convertFrom = convertFrom;
		this.convertTo = convertTo;
    }

    public String getFile() {
        return file;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getExit() {
        return exit;
    }

    public String getHelp() {
        return help;
    }

    public String getAbout() {
        return about;
    }

    public String getConvertFrom() {
        return convertFrom;
    }

    public String getConvertTo() {
        return convertTo;
    }
 }
 
