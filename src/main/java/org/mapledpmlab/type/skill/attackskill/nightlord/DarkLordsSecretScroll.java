package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkLordsSecretScroll extends AttackSkill {
    public DarkLordsSecretScroll() {
        this.setName("다크로드의 비전서");
        this.setAttackCount(12L);
        this.setCooldown(60.0);
        this.setDamage(935.0);
        this.setDotDuration(12000L);
        this.setInterval(990L);
        this.setAddDamage(30L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new DarkLordsSecretScrollDelay());
    }
}
