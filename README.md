# NetworkEndpoint
Java program which finds the terminal node of a simple network.



The goal of this program is to find the terminal node of a simple network.

In that simple network, every node is linked to at more one outgoing node in a unidirectional way.

The ‘’findNetworkEndpoint(startNodeId, fromIds, toIds) method return the id of the last node of the found network started from the ‘’startNodeId’’ node and following the network's links.

‘’fromIds’’ and ‘’toIds’’ are two table with the same length describing the unidirectional links of the network. (‘’fromIds[i] is linked to toIds[i]).

In the case the program find a loop when running the network, the method return the id of the last node crossed before closing the loop.
