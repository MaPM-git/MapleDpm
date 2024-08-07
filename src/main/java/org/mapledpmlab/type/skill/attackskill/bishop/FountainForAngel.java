package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FountainForAngel extends AttackSkill {
    public FountainForAngel() {
        this.setName("파운틴 포 엔젤");
        this.setDamage(180.0);
        this.setAttackCount(5L);
        this.setDelayByAttackSpeed(960L);
        this.setCooldown(60.0);             // 갱신용
        this.setDotDuration(60000L);
        this.setInterval(2010L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
