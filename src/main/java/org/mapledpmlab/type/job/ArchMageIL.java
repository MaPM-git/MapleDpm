package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BuffBossCritical;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.BuffFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.IntUnion;

public class ArchMageIL extends Job {

    public ArchMageIL() {
        // 기본
        super();
        this.setDescription("아크메이지 썬, 콜");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BuffBossCritical());
        this.addObject(new BuffFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new IntUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);

        // 2차
        this.addMagic(30L);             // 메디테이션
        this.addMainStat(20L);          // 매직 액셀레이션
        this.addMagic(10L);             // 스펠 마스터리
        this.addMainStat(40L);          // 하이 위즈덤

        // 3차
        this.addProperty(10L);          // 엘리멘탈 리셋
        this.addFinalDamage(1.4);
        this.addCriticalP(30.0);        // 매직 크리티컬
        this.addCriticalDamage(13.0);

        // 4차
        this.addIgnoreDefenseList(21L);  // 아케인 에임
        this.addMagic(33L);             // 마스터 매직
        this.addPlusBuffDuration(55L);

        // 5차
        this.addMainStat(30L);          // 언스태이블 메모라이즈
    }

    @Override
    public void Doping() {
        super.Doping();
        addCriticalDamage(15.0);        // 프로스트 이펙트
        addIgnoreDefenseList(10L);      // 프로즌 브레이크
        addFinalDamage(1.2);            // 익스트림 매직
        addDamage(50L);                 // 앨리먼트 앰플리케이션
        addDamage(40L);                 // 아케인 에임
        addFinalDamage(1.08);           // 오버로드 마나
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
