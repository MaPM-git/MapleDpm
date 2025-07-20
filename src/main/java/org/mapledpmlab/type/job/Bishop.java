package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BuffBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Bishop extends Job {

    public Bishop() {
        // 기본
        super();
        this.setName("비숍(0초, 리레단일)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.95 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(3296370.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addMagic((long) (406 + 250 + 72 + 276));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        passive.addMagicP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (10 + 80 + 75));
        passive.addSubStat(75L);
        passive.addAtt(45L);
        passive.addMagic((long) (1 + 45));
        passive.addBossDamage(70L);
        passive.addMagicP(9L);
        passive.addMagicP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("매직 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스펠 마스터리");
        passive.addMagic(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("하이 위즈덤");
        passive.addMainStat(40L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("매직 크리티컬");
        passive.addCriticalP(30.0);
        passive.addCriticalDamage(16.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("홀리 포커스");
        passive.addCriticalP(40.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("블레싱 하모니");
        passive.addFinalDamage(1.06);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 블레스(쓸어블 대체)");
        passive.addAtt(51L);
        passive.addMagic(51L);
        passive.addAtt(-20L);
        passive.addMagic(-20L);
        passive.addBossDamage(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("아케인 에임");
        passive.addIgnoreDefenseList(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("마스터 매직");
        passive.addMagic(33L);
        passive.addPlusBuffDuration(55L);
        passive.addFinalDamage(1.11);
        getPassiveList().add(passive);

        // 하이퍼
        passive = new Common();
        passive.setDescription("벤전스 오브 엔젤");
        passive.addMagic(50L);
        passive.addFinalDamage(1.3);
        passive.addIgnoreDefenseList(20L);
        passive.addProperty(10L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("언스태이블 메모라이즈");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        // 6차
        passive = new Common();
        passive.setDescription("프레이 강화");
        passive.addMainStat(90L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-3L);
        this.addMainStat(3L);
        this.addSubStat(-5L);
        //this.addMagic(-7L);

        this.setAbility(new BuffBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());

        this.addObject(getPassiveList());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("브레싱 앙상블");
        doping.addFinalDamage(1.01);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("아케인 에임");
        doping.addDamage(40L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("엔젤릭 터치 상시 유지");
        doping.addIgnoreDefenseList(44L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("세이람의 영약 수치 제외(어블 대체)");
        doping.addAtt(-30L);
        doping.addMagic(-30L);
        doping.addBossDamage(-10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 블레스(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addMagic(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("마스터 매직(콜렉터의 영약)");
        doping.addMagic(3L);
        doping.addPlusBuffDuration(5L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
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
