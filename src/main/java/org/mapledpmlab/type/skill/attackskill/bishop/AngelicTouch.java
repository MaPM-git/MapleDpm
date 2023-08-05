package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AngelicTouch extends AttackSkill {
    public AngelicTouch() {
        this.setName("엔젤릭 터치");
        this.setDamage(350.0);
        this.setAttackCount(5L);
        this.setCooldown(60.0);             // 갱신용
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(3.4);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
