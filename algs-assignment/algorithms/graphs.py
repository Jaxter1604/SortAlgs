import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

# Constants based on your description
num_algorithms = 10
num_files = 7
algorithm_names = [f"Algorithm {i+1}" for i in range(num_algorithms)]
file_sizes = [f"File {i+1}" for i in range(num_files)]  # Placeholder for actual file sizes if known

# Read raw data
df = pd.read_csv("results/results.csv", header=None)  # No headers in the file

# Reshape into a DataFrame
df = df.values.reshape(num_files, num_algorithms)  # Reshape so each row corresponds to a file size

# Convert to DataFrame for easier plotting
df = pd.DataFrame(df, columns=algorithm_names, index=file_sizes)

# Plot
plt.figure(figsize=(10, 6))
for algorithm in df.columns:
    plt.plot(df.index, df[algorithm], marker='o', label=algorithm)

# Log scale for better visualization
plt.yscale("log")

# Labels and Title
plt.xlabel("File Size (Ordered from Smallest to Largest)")
plt.ylabel("Time (nanoseconds)")
plt.title("Sorting Time Comparison (Log Scale)")
plt.legend()
plt.grid(True, which="both", linestyle="--")

# Show plot
plt.show()
