# Flu Epidemic
[![Build Status](https://travis-ci.com/loick111/flu-epidemic.svg?token=JYk1pm9i6DwDqFepCWeZ)](https://travis-ci.com/loick111/flu-epidemic)

Winter is coming - this project is a simulation of a flu (influenza) epidemic. Obviously this will be a simplification of real-world epidemics. The simulation consists of both a disease model describing characteristics of the illness, and a social model describing how people interact with each other.

We start with the basic element of the simulation – a person. We'll abstract away most of the details we associate with people since only a few qualities interest us. At any given time, a person can be in one of several states:

    *   Healthy: healthy people can become sick only after they come in contact with people who are contagious. But not always - this depends on the infection rate of the disease, only some percentage of exposed people may become ill.
    *   Sick: after contact with a contagious person, a healthy person may become sick because they catch a virus from the contagious person.
    *   Contagious: a few days (this is the incubation time and depends on the specific virus of infection) after infection, a sick person becomes contagious and may transmit the disease to other people with whom they come into contact.
    *   Recovering: some time after becoming contagious a person either gets over the illness and starts recovering, or...dies of the illness. A recovering person is no longer contagious and becomes healthy again after a few more days.
    *   Dead: depending on the mortality rate of the disease, a person may recover or die. A dead person stays dead. Sorry, no zombies here :^( .

The times in the simulation disease model (from sick to contagious, from contagious to recovery or dead, from recovering to healthy) are fixed for each type of virus, but should be different for each type of virus.

The simulation also consists of three other elements: chickens, ducks and pigs. These have much the same behaviour as people, they can be in the same states and they can be infectious (chickens and ducks can infect each other with the H5N1 virus, pigs infect pigs with the H1N1 virus ) with different incubation times and mortality rates. However, infected animals never recover from the infection, ie, there is no recovering state for animals; they may stay contagious or they may die from it. Rarely, an animal can infect a person with its virus, which people can then pass on to other people as described above.

The social model describes the behaviour of the simulation elements. They all live together on a two-dimensional grid and are in contact with other elements situated within a neighbourhood on the grid. The notion of neighbourhood is a parameter of the simulation, eg, this can be the 4-neighbourhood of row and column neighbours, or the 8-neighbourhood which includes diagonal neighbours, or some other neighbourhood. An element does not necessarily contact all of its neighbours; perhaps a fixed number or some percentage. Contagious elements can infect healthy elements they come into contact with, within the rules given above.

The simulation itself proceeds by steps of a day at a time. The grid is initialized with all people being healthy, but with some animals already being sick with their specific virus. At the first step, each element determines which state they should next assume, and so on. The simulation ends when there is no more change, all entities are either healthy or dead.

People can move on the grid into adjacent empty squares (only one element can occupy a square). This can bring them into contact with new elements. Sick, contagious and recovering people move more slowly than healthy people. Animals don't move.

## Variants
There are lots of possibilities, including:

    *   Individual characteristics which can affect the infection rate, eg, different inherent resistance to the disease, or different habits such as frequent hand-washing.
    *   Individual characteristics which can affect the mortality rate, eg, a general fitness level.
    *   Someone who has been exposed and has recovered develops antibodies which confer resistance to further infection.
    *   Different population patterns, ie, not every grid point has to be populated.
    *   Some individuals may be vaccinated against the viruses.
    *   People may move non-randomly on the grid, eg, moving away from infection.
    *   Changing weather can change infection rates.
    *   Invent your own...

## Constraints
Code must be professional - clean and commented.
You must implement at least two variants.
Project delivery is on the course Moodle site.
Code delivery is in the form of a .jar archive file only. The archive does not include .class files.
Deliverables also include a Readme.txt file with instructions on how to run the application from the command line.
Unconstraints
Use the development tool of your choice.
Use the operating system of your choice.
Use the hardware of your choice.

## Team
    *   Loïck MAHIEUX
    *   Ulysse RICCIO
    *   Jihane SBAYTTI