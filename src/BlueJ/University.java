public class University {	
    private String name;
    private String country;
    private int nationalRank;
    private int qualityOfEducation;
    private int alumniEmployment;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNationalRank(){
        return nationalRank;
    }

    public void setNationalRank(int nationalRank){
        this.nationalRank = nationalRank;
    }

    public int getQualityOfEducation() {
        return qualityOfEducation;
    }

    public void setQualityOfEducation(int qualityOfEducation) {
        this.qualityOfEducation = qualityOfEducation;
    }

    public int getAlumniEmployment() {
        return alumniEmployment;
    }

    public void setAlumniEmployment(int alumniEmployment) {
        this.alumniEmployment = alumniEmployment;
    }

    public University(String name, String country, int nationalRank, int qualityOfEducation, int alumniEmployment) {
        this.name = name;
        this.country = country;
        this.nationalRank = nationalRank;
        this.qualityOfEducation = qualityOfEducation;
        this.alumniEmployment = alumniEmployment;
    }

    public boolean equals(University p){
        if(this.name.equals(p.getName()) && this.country.equals(p.getCountry()) && 
        this.nationalRank == p.getNationalRank() &&	this.qualityOfEducation == p.getQualityOfEducation() && 
        this.alumniEmployment == p.getAlumniEmployment()){
            return true;
        }
        return false;
    }

    public double distance(University p) {
        double qualOfEduDist;
        double alumniEmploymentDist;
        double rankDist;
        qualOfEduDist = Math.pow(this.qualityOfEducation - p.getQualityOfEducation(), 2);
        alumniEmploymentDist = Math.pow(this.alumniEmployment - p.getAlumniEmployment(), 2);
        rankDist = Math.pow(this.nationalRank - p.getNationalRank(), 2);
        return Math.sqrt(qualOfEduDist + alumniEmploymentDist + rankDist);
    }

    public void printUniversity() {
        System.out.print(this.name);

    }
}
