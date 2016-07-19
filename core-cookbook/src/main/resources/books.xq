xquery version "3.0";

(:~
: User: tk3sy
: Date: 19.07.2016
: Time: 15:30
: To change this template use File | Settings | File Templates.
:)

for $x in doc("books.xml")/books/book
where $x/price>30
return $x/title