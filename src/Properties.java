public class Properties {	
	private String university;
	private String country;
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
	
	public Properties(String university, String country, int qualityOfEducation, int alumniEmployment) {
		this.university = university;
		this.country = country;
		this.qualityOfEducation = qualityOfEducation;
		this.alumniEmployment = alumniEmployment;
	}
	
	public boolean equals(Properties p){
		if(this.university.equals(p.getUniversity()) && this.country.equals(p.getCountry()) && this.qualityOfEducation ==
				p.getQualityOfEducation() && this.alumniEmployment == p.getAlumniEmployment()){
			return true;
		}
		return false;
	}
	
	public double distance(Properties p) {
		double qualOfEduDist;
		double alumniEmploymentDist;
		
		qualOfEduDist = Math.pow(this.qualityOfEducation - p.getQualityOfEducation(), 2);
		alumniEmploymentDist = Math.pow(this.alumniEmployment - p.getAlumniEmployment(), 2);
		
		return Math.sqrt(qualOfEduDist + alumniEmploymentDist);
	}
	
	public void printProperties() {
		System.out.println(this.university);
		System.out.println(this.country);
		System.out.println(this.qualityOfEducation);
		System.out.println(this.alumniEmployment);

	}
}
