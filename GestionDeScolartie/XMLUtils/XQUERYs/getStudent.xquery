declare variable $CNE external;
declare variable $filiere external;
declare variable $niveau external;

declare variable $modules := doc(fn:concat("../../OUTPUT/Notes/XMLFiles/","Notes_",$filiere,$niveau,".xml"))/Note//Modules//Module;
declare variable $firstName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CNE]/firstName;
declare variable $lastName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CNE]/lastName;
declare variable $DateofBirth := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CNE]/dateOfBirth;
declare variable $ClasseName := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CNE]/className;
declare variable $Phone := doc(fn:concat("../../OUTPUT","/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CNE]/phone;
declare variable $Email := doc(fn:concat("../../OUTPUT","/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student[@CNE=$CNE]/email;

<student CNE="{$CNE}">
    {$firstName}
    {$lastName}
    {$DateofBirth}
    {$ClasseName}
    {$Phone}
    {$Email}
    <notes>
        <modules>
            {
                for $module in $modules
                    return <module code="{$module/@code}">{doc(fn:concat("../../OUTPUT/Notes/XMLFiles/", "Notes_", $filiere, $niveau, ".xml"))/Note/Modules//Module[@code=$module/@code]/Students/Student[@CNE = $CNE]/moyenne}</module>
            }
        </modules>
    </notes>
</student>

