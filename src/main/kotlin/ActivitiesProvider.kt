package com.github.lindsaygelle

interface ActivitiesProvider {
    fun getActivities(receivers: List<ActionReceiver>): List<Activity>
}