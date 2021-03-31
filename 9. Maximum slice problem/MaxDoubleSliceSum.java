// accidentally forget to copy them 

// basic idea is to find maximum slice from front and back, with careful edge cases dsf[0] = 0 and dsb[n-1] = 0
// then to find the maximum double slice by iterating through y from 1 to n - 2
// its DP problem, DP[y] = max(0, dsf[y-1]) + max(0, dsb[y+1])
// goal is max(DP[y]) for all y
