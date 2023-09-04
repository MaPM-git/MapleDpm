package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhoenixDriveAfterSecond extends AttackSkill {
    public PhoenixDriveAfterSecond() {
        this.setName("피닉스 드라이브(2, 3, 4타)");
        this.setDamage(450.0);
        this.setAttackCount(2L);
        this.setDotDuration(3L);
        this.setInterval(1L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(0.5);
        this.addFinalDamage(2.2);
        this.addIgnoreDefenseList(20L);
    }
}
