def bellman_ford(W, s):
    n = len(W)          # nombre de sommets
    INF = float("inf")

    # Initialisation
    Dist = [INF] * n
    Pred = [None] * n

    Dist[s] = 0

    k = 1
    Update = True

    # Boucle principale
    while k <= n - 1 and Update:
        Update = False

        for x in range(n):
            print(f"Vérification des arêtes sortantes du sommet {x}")
            if Dist[x] == INF:
                continue

            for y in range(n):
                
                if W[x][y] != INF:
                    if Dist[x] + W[x][y] < Dist[y]:
                        Dist[y] = Dist[x] + W[x][y]
                        Pred[y] = x
                        Update = True
                        print(f"Iteration {k}: Mise à jour de la distance de {y} à {Dist[y]} via {x}")
                    else:
                        print(f"Rien de changé pour le sommet {y}")
        k += 1

    # Détection de cycle négatif
    cycle_negatif = False

    for x in range(n):
        if Dist[x] == INF:
            continue

        for y in range(n):
            if W[x][y] != INF:
                if Dist[x] + W[x][y] < Dist[y]:
                    cycle_negatif = True

    return Dist, Pred, cycle_negatif
# Exemple d'utilisation
if __name__ == "__main__":
    INF = float("inf")
    W = [
        [0, 8, 6, 2, INF],
        [INF, 0 ,  -5, INF, 7],
        [INF, INF, 0, INF, 1],
        [INF, INF, INF, 0, INF],
        [INF, INF, INF, INF, 0]
    ]
    s = 0
    Dist, Pred, cycle_negatif = bellman_ford(W, s)
    print("Distances:", Dist)
    print("Predecessors:", Pred)
    print("Cycle négatif détecté:", cycle_negatif)

# Algorithme de Bellman-Ford pour le plus court chemin dans un graphe pondéré