public class Properties {	
	private String university;
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
	
	public String getUniversity(){
		return university;
	}
	
	public void setUniversity(String university){
		this.university = university;
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
	
	public Properties(String university, String country, int nationalRank, int qualityOfEducation, int alumniEmployment) {
		this.university = university;
		this.country = country;
		this.nationalRank = nationalRank;
		this.qualityOfEducation = qualityOfEducation;
		this.alumniEmployment = alumniEmployment;
	}
	
	public boolean equals(Properties p){
		if(this.university.equals(p.getUniversity()) && this.country.equals(p.getCountry()) && 
				this.nationalRank == p.getNationalRank() &&	this.qualityOfEducation == p.getQualityOfEducation() && 
				this.alumniEmployment == p.getAlumniEmployment()){
			return true;
		}
		return false;
	}
	
	public double distance(Properties p) {
		double qualOfEduDist;
		double alumniEmploymentDist;
		double rankDist;
		qualOfEduDist = Math.pow(this.qualityOfEducation - p.getQualityOfEducation(), 2);
		alumniEmploymentDist = Math.pow(this.alumniEmployment - p.getAlumniEmployment(), 2);
		rankDist = Math.pow(this.nationalRank - p.getNationalRank(), 2);
		return Math.sqrt(qualOfEduDist + alumniEmploymentDist + rankDist);
	}
	
	public void printProperties() {
		System.out.println(this.university);
		System.out.println(this.country);
		System.out.println(this.nationalRank);
		System.out.println(this.qualityOfEducation);
		System.out.println(this.alumniEmployment);
	}
}
