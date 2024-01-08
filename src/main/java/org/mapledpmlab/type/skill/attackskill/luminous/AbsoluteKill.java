package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbsoluteKill extends AttackSkill {
    public AbsoluteKill() {
        this.setName("앱솔루트 킬");
        this.setDamage(695.0);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(7L * 2);
        this.addIgnoreDefenseList(45L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.05);  // 어둠 마법 강화
        this.setAddDamage(20L);     // 앱솔루트 킬-리인포스
    }
}
