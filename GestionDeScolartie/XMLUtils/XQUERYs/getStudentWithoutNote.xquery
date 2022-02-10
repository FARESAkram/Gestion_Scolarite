declare variable $CNE external;
declare variable $filiere external;
declare variable $niveau external;

declare variable $firstName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//Student[@CNE=$CNE]/firstName;
declare variable $lastName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//Student[@CNE=$CNE]/lastName;
declare variable $DateofBirth := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//Student[@CNE=$CNE]/dateOfBirth;
declare variable $ClasseName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//Student[@CNE=$CNE]/className;
declare variable $Phone := doc(fn:concat("../../OUTPUT","/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//Student[@CNE=$CNE]/phone;
declare variable $Email := doc(fn:concat("../../OUTPUT","/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//Student[@CNE=$CNE]/email;
declare variable $photo external;

<student CNE="{$CNE}">
    {$firstName}
    {$lastName}
    {$DateofBirth}
    {$ClasseName}
    {$Phone}
    {$Email}
    <photo>{$photo}</photo>
</student>

