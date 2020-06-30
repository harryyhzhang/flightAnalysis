# Make download directory
dir=$(pwd)
mkdir -p $dir/data/flights

# Download flight data by year
for i in {2004..2008}
  do
    echo "$(date) $i Download"
    fnam=$i.csv.bz2
    wget -O $dir/data/flights/$fnam http://stat-computing.org/dataexpo/2009/$fnam
    echo "$(date) $i Unzip"
    bunzip2 $dir/data/flights/$fnam
  done

# Download airline carrier data
wget -O $dir/data/airlines.csv http://www.transtats.bts.gov/Download_Lookup.asp?Lookup=L_UNIQUE_CARRIERS

# Download airports data
wget -O $dir/data/airports.csv https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat
