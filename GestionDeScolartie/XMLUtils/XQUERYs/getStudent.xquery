declare variable $CIN external;
declare variable $filiere external;
declare variable $niveau external;

declare variable $Notes := doc(fn:concat("../../OUTPUT/Notes/XMLFiles/","Notes_",$filiere,$niveau,".xml"))/Note//Modules/Module/Students//Student[@CNE=$CIN]/moyenne;
declare variable $firstName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CIN]/firstName;
declare variable $lastName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CIN]/lastName;
declare variable $DateofBirth := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CIN]/dateOfBirth;
declare variable $ClasseName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CIN]/className;
declare variable $Phone := doc(fn:concat("../../OUTPUT","/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CIN]/phone;
declare variable $Email := doc(fn:concat("../../OUTPUT","/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CIN]/email;

<student>
    {$firstName}
    {$lastName}
    {$DateofBirth}
    {$ClasseName}
    {$Phone}
    {$Email}
    <notes>
        {$Notes}
    </notes>
</student>


