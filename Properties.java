public class Properties {
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getNationalRank() {
		return nationalRank;
	}
	public void setNationalRank(int nationalRank) {
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
	public int getQualityOfFaculty() {
		return qualityOfFaculty;
	}
	public void setQualityOfFaculty(int qualityOfFaculty) {
		this.qualityOfFaculty = qualityOfFaculty;
	}
	
	public Properties(String country, int nationalRank, int qualityOfEducation, int alumniEmployment, int qualityOfFaculty) {
		this.country = country;
		this.nationalRank = nationalRank;
		this.qualityOfEducation = qualityOfEducation;
		this.alumniEmployment = alumniEmployment;
		this.qualityOfFaculty = qualityOfFaculty;
	}
	
	public double distance(Properties p) {
		double nationalRankDist;
		double qualOfEduDist;
		double alumniEmploymentDist;
		double qualOfFacultyDist;
		
		nationalRankDist = Math.pow(this.nationalRank - p.getNationalRank(), 2);
		qualOfEduDist = Math.pow(this.qualityOfEducation - p.getQualityOfEducation(), 2);
		alumniEmploymentDist = Math.pow(this.alumniEmployment - p.getAlumniEmployment(), 2);
		qualOfFacultyDist = Math.pow(this.qualityOfFaculty - p.getQualityOfFaculty(), 2);
		
		return Math.sqrt(nationalRankDist + qualOfEduDist + alumniEmploymentDist + qualOfFacultyDist);
	}
	
	public void printProperties() {
		System.out.println(this.country);
		System.out.println(this.nationalRank);
		System.out.println(this.qualityOfEducation);

		System.out.println(this.alumniEmployment);
		System.out.println(this.qualityOfFaculty);

	}
	private String country;
	private int nationalRank;
	private int qualityOfEducation;
	private int alumniEmployment;
	private int qualityOfFaculty;
	
}
