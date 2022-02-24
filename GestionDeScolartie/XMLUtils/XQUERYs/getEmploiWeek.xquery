declare variable $numero external;
declare variable $filiere external;
declare variable $niveau external;

declare variable $semaine := doc(fn:concat("../../Base_de_donnée/Emploi/XMLFiles/","Emploi_",$filiere,$niveau,".xml"))//semaine[@num=$numero];


$semaine