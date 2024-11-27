package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

import java.sql.Timestamp;

public class ThornOfFury extends GaugeAttackSkill {
    public ThornOfFury() {
        this.setName("분노의 가시");
        this.setAttackCount(12L);
        this.setDamage(1320.0);
        this.addIgnoreDefenseList(30L);
        this.setCooldown(4.0);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyCooldownReduction(false);
    }

    public void setCooldownByFury(int fury) {
        if (fury == 300000) {
            this.setCooldown(0.4);
        } else if (fury >= 270000) {
            this.setCooldown(0.76);
        } else if (fury >= 240000) {
            this.setCooldown(1.12);
        } else if (fury >= 210000) {
            this.setCooldown(1.48);
        } else if (fury >= 180000) {
            this.setCooldown(1.84);
        } else if (fury >= 150000) {
            this.setCooldown(2.2);
        } else if (fury >= 120000) {
            this.setCooldown(2.56);
        } else if (fury >= 90000) {
            this.setCooldown(2.92);
        } else if (fury >= 60000) {
            this.setCooldown(3.28);
        } else if (fury >= 30000) {
            this.setCooldown(3.64);
        } else {
            this.setCooldown(4.0);
        }
    }

    public void setActivateTimeByFury(Double beforeCooldown) {
        this.setActivateTime(
                new Timestamp(
                        (long) (
                                this.getActivateTime().getTime()
                                + this.getCooldown() * 1000
                                - beforeCooldown * 1000
                        )
                )
        );
    }
}
