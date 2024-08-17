package Beans;

/**
 *
 * @author SYNC
 *
 */
public class postBean {

    private int id;
    private String title;
    private String Description;
    private String archiveName;
    private String repository;
    private boolean frontendProject;
    private boolean backendProject;
    public final String author = "SYNC";

    public postBean() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public boolean isFrontendProject() {
        return frontendProject;
    }

    public void setFrontendProject(boolean frontendProject) {
        this.frontendProject = frontendProject;
    }

    public boolean isBackendProject() {
        return backendProject;
    }

    public void setBackendProject(boolean backendProject) {
        this.backendProject = backendProject;
    }

    public String getAuthor() {
        return author;
    }

 
}
